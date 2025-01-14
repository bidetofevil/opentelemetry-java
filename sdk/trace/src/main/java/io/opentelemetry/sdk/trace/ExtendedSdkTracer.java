/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.incubator.trace.ExtendedSpanBuilder;
import io.opentelemetry.api.incubator.trace.ExtendedTracer;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.trace.internal.TracerConfig;

/** {@link ExtendedSdkTracer} is SDK implementation of {@link ExtendedTracer}. */
final class ExtendedSdkTracer extends SdkTracer implements ExtendedTracer {
  // TODO: add dedicated API for updating scope config.
  @SuppressWarnings("FieldCanBeFinal") // For now, allow updating reflectively.
  private boolean tracerEnabled;

  ExtendedSdkTracer(
      TracerSharedState sharedState,
      InstrumentationScopeInfo instrumentationScopeInfo,
      TracerConfig tracerConfig) {
    super(sharedState, instrumentationScopeInfo, tracerConfig);
    this.tracerEnabled = tracerConfig.isEnabled();
  }

  @Override
  public boolean isEnabled() {
    return tracerEnabled;
  }

  @Override
  public ExtendedSpanBuilder spanBuilder(String spanName) {
    return (ExtendedSpanBuilder) super.spanBuilder(spanName);
  }
}
