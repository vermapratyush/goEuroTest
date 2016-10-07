package com.goeuro.interview.service;

/**
 * Implement the interface to make a service identifiable.
 * This can be implemented in Service to ensure that all the implementation of Service is uniquely identifiable.
 * The unique identity can be used to migrate to newer version of a service.
 */
interface IIdentifiable {
    String getId();
    String getName();
    String getVersion();
}
