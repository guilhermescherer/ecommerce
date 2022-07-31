package com.ecommerce.shipping.service.impl;

import com.ecommerce.shipping.model.State;
import com.ecommerce.shipping.repository.StateRepository;
import com.ecommerce.shipping.service.StateService;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State getStateById(Long id) {
        return isNull(id) ? null : stateRepository.findById(id).orElse(null);
    }
}
