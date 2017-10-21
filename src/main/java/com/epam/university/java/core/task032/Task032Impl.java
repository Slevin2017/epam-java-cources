package com.epam.university.java.core.task032;

import java.lang.reflect.Proxy;

public class Task032Impl implements Task032 {
    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl(new SomeActionExecutorImpl());
}

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        return ((CountingProxyImpl)proxy).executor();
    }
}
