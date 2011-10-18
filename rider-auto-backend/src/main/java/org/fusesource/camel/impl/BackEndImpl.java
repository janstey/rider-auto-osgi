package org.fusesource.camel.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fusesource.camel.model.Order;

public class BackEndImpl {
    private static final Log LOG = LogFactory.getLog(BackEndImpl.class);

    public void doWork(Order order) {
        LOG.info("Received order for " + order.getAmount() + " " + order.getName());
    }
}
