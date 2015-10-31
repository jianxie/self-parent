package net.xiejian.disruptor.example2;

import com.lmax.disruptor.EventFactory;

public class ValueEventFactory implements EventFactory<ValueEvent> {

	public ValueEvent newInstance() {
		return new ValueEvent();
	}

}
