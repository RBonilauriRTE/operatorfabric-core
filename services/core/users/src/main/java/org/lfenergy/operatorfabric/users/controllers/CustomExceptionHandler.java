/* Copyright (c) 2018, RTE (http://www.rte-france.com)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.lfenergy.operatorfabric.users.controllers;

import lombok.extern.slf4j.Slf4j;
import org.lfenergy.operatorfabric.springtools.error.model.ApiErrorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * CustomExceptionHandler.
 * <ul>
 *     <li>Handle Api errors according to their configuration</li>
 *     <li>Handle uncaught logging error</li>
 * </ul>
 *
 * @see org.lfenergy.operatorfabric.springtools.error.model.ApiError
 * @see ApiErrorException
 *
 * @author David Binder
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  public static final String GENERIC_MSG = "Caught exception at API level";

  @ExceptionHandler(ApiErrorException.class)
  public ResponseEntity<Object> handleApiError(ApiErrorException exception, final WebRequest
     request) {
    log.info(GENERIC_MSG,exception);
    return new ResponseEntity<>(exception.getError(), exception.getError().getStatus());
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
    log.error("Uncaught internal server exception",ex);
    return super.handleExceptionInternal(ex, body, headers, status, request);
  }
}