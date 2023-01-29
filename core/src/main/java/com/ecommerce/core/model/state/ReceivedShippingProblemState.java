package com.ecommerce.core.model.state;

import com.ecommerce.core.model.Order;
import com.ecommerce.core.model.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("ReceivedShippingProblem")
public class ReceivedShippingProblemState extends State {

	private static final String NAME = "ReceivedShippingProblem";

	@Override
	public String getClassName() {
		return NAME;
	}

	@Override
	public void toCollected(Order order) {
		order.setState(new CollectedState());
	}
}