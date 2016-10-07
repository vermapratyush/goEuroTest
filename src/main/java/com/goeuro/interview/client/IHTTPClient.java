package com.goeuro.interview.client;

import com.mashape.unirest.http.HttpResponse;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * All HTTP Clients should implement this interface.
 * For now we are using Unirest, if this changes in future the implementation will change
 * however the classes using IHTTPClient will remain unaffected.
 */
interface IHTTPClient {
    Future<HttpResponse<InputStream>> Get(String url, Map<String, String> headers);
    Future<HttpResponse<InputStream>> Post(String url, Map<String, String> headers, Object body);
    Future<HttpResponse<InputStream>> Put(String url, Map<String, String> headers, Object body);
}
