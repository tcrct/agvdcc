package com.agvdcc.service;

import com.agvdcc.core.interfaces.IService;

public abstract class BaseService<T> implements IService {

    public abstract String setRout(T protocol);

}
