/*
 * Copyright 2015 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.tudelft.graphalytics.domain.benchmark;

import nl.tudelft.graphalytics.domain.Algorithm;
import nl.tudelft.graphalytics.domain.Benchmark;
import nl.tudelft.graphalytics.domain.GraphSet;
import nl.tudelft.graphalytics.util.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlngai on 10/14/16.
 */
public class BenchmarkJob {
    String id;
    Algorithm algorithm;
    GraphSet graphSet;
    int resourceSize;
    int repetition;
    List<Benchmark> benchmarks;

    public BenchmarkJob(Algorithm algorithm, GraphSet graphSet, int resourceSize, int repetition) {
        this.id = UuidGenerator.getRandomUUID("j", 6);
        this.algorithm = algorithm;
        this.graphSet = graphSet;
        this.resourceSize = resourceSize;
        this.repetition = repetition;
        this.benchmarks = new ArrayList<>();
    }

    public BenchmarkJob(String id, Algorithm algorithm, GraphSet graphSet, int resourceSize, int repetition) {
        this.id = id;
        this.algorithm = algorithm;
        this.graphSet = graphSet;
        this.resourceSize = resourceSize;
        this.repetition = repetition;
        this.benchmarks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public GraphSet getGraphSet() {
        return graphSet;
    }

    public int getResourceSize() {
        return resourceSize;
    }

    public int getRepetition() {
        return repetition;
    }

    public List<Benchmark> getBenchmarks() {
        return benchmarks;
    }

    public void addBenchmark(Benchmark benchmark) {
        benchmarks.add(benchmark);
    }

}