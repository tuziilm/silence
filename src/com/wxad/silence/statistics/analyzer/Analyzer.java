package com.wxad.silence.statistics.analyzer;

import com.wxad.silence.statistics.common.ChartPvUvData;

import java.util.List;

public interface Analyzer {
    List<ChartPvUvData> analyze() throws Exception;
}
