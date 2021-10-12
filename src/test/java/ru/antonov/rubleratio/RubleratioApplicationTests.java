package ru.antonov.rubleratio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RubleratioApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OpenExchangeRatesClient openExchangeRatesClient;
	@Autowired
	private Environment env;

	@Test
	void testOpenExchangeRates() throws Exception {
		OpenExchangeRatesModel today = new OpenExchangeRatesModel();
		today.setRates(Map.of("UAH", BigDecimal.valueOf(26.402488)));
		given(this.openExchangeRatesClient.getModel(
				LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),
				env.getProperty("oer.app_id"),
				env.getProperty("oer.base")))
				.willReturn(today);

		OpenExchangeRatesModel yesterday = new OpenExchangeRatesModel();
		yesterday.setRates(Map.of("UAH", BigDecimal.valueOf(26.365275)));
		given(this.openExchangeRatesClient.getModel(
				LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE),
				env.getProperty("oer.app_id"),
				env.getProperty("oer.base")))
				.willReturn(yesterday);

		// Must be RICH gif
		mockMvc.perform(get("/UAH"))
				.andExpect(status().isOk())
				.andDo(print());
	}
}
