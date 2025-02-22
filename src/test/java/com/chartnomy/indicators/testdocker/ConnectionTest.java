package com.chartnomy.indicators.testdocker;

import static com.chartnomy.indicators.domain.kospi.entity.QKospi.kospi;
import com.chartnomy.indicators.domain.kospi.entity.Kospi;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("testdocker")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class ConnectionTest{

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private DataSource dataSource;

	private JPAQueryFactory queryFactory;

	@BeforeAll
	void setupApplication(){
		queryFactory = new JPAQueryFactory(entityManager);
	}

//	@Disabled
	@DisplayName("DB 셋업")
	@Test
	@Order(1)
	@Sql(scripts = {
		"/datasets/mariadb/ddl/schema.sql",
		"/datasets/mariadb/insert/mariadb_insert_date_axis_dd.sql",
		"/datasets/mariadb/insert/mariadb_insert_kospi_day.sql",
		"/datasets/mariadb/insert/mariadb_insert_loan_corporate_month.sql",
		"/datasets/mariadb/insert/mariadb_insert_loan_household_month.sql",
		"/datasets/mariadb/insert/mariadb_insert_loan_rate_kor.sql",
		"/datasets/mariadb/insert/mariadb_insert_loan_rate_usa.sql",
		"/datasets/mariadb/insert/mariadb_insert_exchange_dollar_day.sql",
	}, config = @SqlConfig(dataSource = "dataSource"))
	void setupSchema(){
	}

	@Test
	@Order(2)
	void test_connection(){
//		List<Kospi> fetch = queryFactory.selectFrom(kospi)
//			.fetch();
//		System.out.println(fetch);
	}
}
