package com.chartnomy.indicators.domain.axis.entity;

import com.chartnomy.indicators.domain.exchange.entity.ExchangeRateWonDollar;
import com.chartnomy.indicators.domain.kospi.entity.Kospi;
import com.chartnomy.indicators.domain.loan.entity.LoanKr;
import com.chartnomy.indicators.domain.loan.entity.LoanUs;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "DATE_AXIS_DD")
public class DateAxisDd {
	@Id
	@Column(name = "yyyymmdd")
	private LocalDateTime date;

	@ManyToOne
//	@JoinColumn(name = "TIME")
	@JoinColumn(name = "TIME", insertable = false, updatable = false)
	private Kospi kospi;

	@ManyToOne
	@JoinColumn(name = "TIME", insertable = false, updatable = false)
	private LoanKr loanKr;

	@ManyToOne
	@JoinColumn(name = "TIME", insertable = false, updatable = false)
	private LoanUs loanUs;

	@ManyToOne
	@JoinColumn(name = "TIME", insertable = false, updatable = false)
	private ExchangeRateWonDollar exchangeRateWonDollar;

	@Column(name = "yyyy")
	private String year;

	@Column(name = "mm")
	private String month;

	@Column(name = "dd")
	private String dayOfMonth;

	public DateAxisDd(){}
}
