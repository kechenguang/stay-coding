package Proxy.Test;

import Proxy.Company;

public class StaticProxy implements Company {

    private Company targer;

    public StaticProxy(Company company) {
        targer = company;
    }

    @Override
    public void work() {
        System.out.println("static proxy");
        targer.work();
        System.out.println("static end");
    }
}
