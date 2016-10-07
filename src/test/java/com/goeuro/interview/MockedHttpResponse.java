package com.goeuro.interview;

import com.mashape.unirest.http.*;
import org.apache.http.*;
import org.apache.http.HttpResponse;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.*;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by pratyushverma on 10/7/16.
 */
public class MockedHttpResponse {

    public static Future<com.mashape.unirest.http.HttpResponse<InputStream>> mockedFutureHttpResponseSuccess(String rawBody) {
        return new Future<com.mashape.unirest.http.HttpResponse<InputStream>>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public com.mashape.unirest.http.HttpResponse<InputStream> get() throws InterruptedException, ExecutionException {
                return mockedHttpResponseSuccess(rawBody);
            }

            @Override
            public com.mashape.unirest.http.HttpResponse<InputStream> get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return get();
            }
        };
    }

    public static Future<com.mashape.unirest.http.HttpResponse<InputStream>> mockedFutureHttpResponseFailure() {
        return new Future<com.mashape.unirest.http.HttpResponse<InputStream>>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public com.mashape.unirest.http.HttpResponse<InputStream> get() throws InterruptedException, ExecutionException {
                return mockedHttpResponseFailure();
            }

            @Override
            public com.mashape.unirest.http.HttpResponse<InputStream> get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return get();
            }
        };
    }

    public static com.mashape.unirest.http.HttpResponse<InputStream> mockedHttpResponseSuccess(String rawBody) {
        return new com.mashape.unirest.http.HttpResponse<>(new HttpResponse() {
            @Override
            public StatusLine getStatusLine() {
                return new StatusLine() {
                    @Override
                    public ProtocolVersion getProtocolVersion() {
                        return null;
                    }

                    @Override
                    public int getStatusCode() {
                        return 200;
                    }

                    @Override
                    public String getReasonPhrase() {
                        return null;
                    }
                };
            }

            @Override
            public void setStatusLine(StatusLine statusLine) {

            }

            @Override
            public void setStatusLine(ProtocolVersion protocolVersion, int i) {

            }

            @Override
            public void setStatusLine(ProtocolVersion protocolVersion, int i, String s) {

            }

            @Override
            public void setStatusCode(int i) throws IllegalStateException {

            }

            @Override
            public void setReasonPhrase(String s) throws IllegalStateException {

            }

            @Override
            public HttpEntity getEntity() {
                return new HttpEntity() {
                    @Override
                    public boolean isRepeatable() {
                        return false;
                    }

                    @Override
                    public boolean isChunked() {
                        return false;
                    }

                    @Override
                    public long getContentLength() {
                        return 0;
                    }

                    @Override
                    public Header getContentType() {
                        return null;
                    }

                    @Override
                    public Header getContentEncoding() {
                        return null;
                    }

                    @Override
                    public InputStream getContent() throws IOException, UnsupportedOperationException {
                        return new ByteArrayInputStream(rawBody.getBytes());
                    }

                    @Override
                    public void writeTo(OutputStream outstream) throws IOException {

                    }

                    @Override
                    public boolean isStreaming() {
                        return false;
                    }

                    @Override
                    public void consumeContent() throws IOException {

                    }
                };
            }

            @Override
            public void setEntity(HttpEntity httpEntity) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }

            @Override
            public void setLocale(Locale locale) {

            }

            @Override
            public ProtocolVersion getProtocolVersion() {
                return null;
            }

            @Override
            public boolean containsHeader(String s) {
                return false;
            }

            @Override
            public Header[] getHeaders(String s) {
                return new Header[0];
            }

            @Override
            public Header getFirstHeader(String s) {
                return null;
            }

            @Override
            public Header getLastHeader(String s) {
                return null;
            }

            @Override
            public Header[] getAllHeaders() {
                return new Header[0];
            }

            @Override
            public void addHeader(Header header) {

            }

            @Override
            public void addHeader(String s, String s1) {

            }

            @Override
            public void setHeader(Header header) {

            }

            @Override
            public void setHeader(String s, String s1) {

            }

            @Override
            public void setHeaders(Header[] headers) {

            }

            @Override
            public void removeHeader(Header header) {

            }

            @Override
            public void removeHeaders(String s) {

            }

            @Override
            public HeaderIterator headerIterator() {
                return null;
            }

            @Override
            public HeaderIterator headerIterator(String s) {
                return null;
            }

            @Override
            public HttpParams getParams() {
                return null;
            }

            @Override
            public void setParams(HttpParams httpParams) {

            }
        }, InputStream.class);
    }

    public static com.mashape.unirest.http.HttpResponse<InputStream> mockedHttpResponseFailure() {
        return new com.mashape.unirest.http.HttpResponse<>(new HttpResponse() {
            @Override
            public StatusLine getStatusLine() {
                return new StatusLine() {
                    @Override
                    public ProtocolVersion getProtocolVersion() {
                        return null;
                    }

                    @Override
                    public int getStatusCode() {
                        return 500;
                    }

                    @Override
                    public String getReasonPhrase() {
                        return null;
                    }
                };
            }

            @Override
            public void setStatusLine(StatusLine statusLine) {

            }

            @Override
            public void setStatusLine(ProtocolVersion protocolVersion, int i) {

            }

            @Override
            public void setStatusLine(ProtocolVersion protocolVersion, int i, String s) {

            }

            @Override
            public void setStatusCode(int i) throws IllegalStateException {

            }

            @Override
            public void setReasonPhrase(String s) throws IllegalStateException {

            }

            @Override
            public HttpEntity getEntity() {
                return new HttpEntity() {
                    @Override
                    public boolean isRepeatable() {
                        return false;
                    }

                    @Override
                    public boolean isChunked() {
                        return false;
                    }

                    @Override
                    public long getContentLength() {
                        return 0;
                    }

                    @Override
                    public Header getContentType() {
                        return null;
                    }

                    @Override
                    public Header getContentEncoding() {
                        return null;
                    }

                    @Override
                    public InputStream getContent() throws IOException, UnsupportedOperationException {
                        throw new IOException("Expected Exception");
                    }

                    @Override
                    public void writeTo(OutputStream outstream) throws IOException {

                    }

                    @Override
                    public boolean isStreaming() {
                        return false;
                    }

                    @Override
                    public void consumeContent() throws IOException {

                    }
                };
            }

            @Override
            public void setEntity(HttpEntity httpEntity) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }

            @Override
            public void setLocale(Locale locale) {

            }

            @Override
            public ProtocolVersion getProtocolVersion() {
                return null;
            }

            @Override
            public boolean containsHeader(String s) {
                return false;
            }

            @Override
            public Header[] getHeaders(String s) {
                return new Header[0];
            }

            @Override
            public Header getFirstHeader(String s) {
                return null;
            }

            @Override
            public Header getLastHeader(String s) {
                return null;
            }

            @Override
            public Header[] getAllHeaders() {
                return new Header[0];
            }

            @Override
            public void addHeader(Header header) {

            }

            @Override
            public void addHeader(String s, String s1) {

            }

            @Override
            public void setHeader(Header header) {

            }

            @Override
            public void setHeader(String s, String s1) {

            }

            @Override
            public void setHeaders(Header[] headers) {

            }

            @Override
            public void removeHeader(Header header) {

            }

            @Override
            public void removeHeaders(String s) {

            }

            @Override
            public HeaderIterator headerIterator() {
                return null;
            }

            @Override
            public HeaderIterator headerIterator(String s) {
                return null;
            }

            @Override
            public HttpParams getParams() {
                return null;
            }

            @Override
            public void setParams(HttpParams httpParams) {

            }
        }, InputStream.class);
    }
}
