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

	@Override
	public void toReceived(Order order) {
		order.setState(new ReceivedState());
	}
}
