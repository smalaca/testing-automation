package com.smalaca.testsuite;

import org.checkerframework.checker.units.qual.A;

import java.util.Collections;
import java.util.List;

class TestSuiteService {
    private final TestValidator testValidator;
    private final TestSuiteRepository testSuiteRepository;

    TestSuiteService(TestValidator testValidator, TestSuiteRepository testSuiteRepository) {
        this.testValidator = testValidator;
        this.testSuiteRepository = testSuiteRepository;
    }

    void add(TestSuite testSuite, Author author) {
        if (testValidator.check(testSuite)) {
            testSuiteRepository.save(testSuite, author);
        }
    }

    void add(List<TestSuite> testSuites, Author author) {
        for (TestSuite testSuite : testSuites) {
            if (testValidator.check(testSuite)) {
                testSuiteRepository.save(testSuite, author);
            }
        }
    }

    List<TestSuite> findAll(Author author) {
        if (testSuiteRepository.existsFor(author)) {
            return testSuiteRepository.findAllFor(author);
        } else {
            return Collections.emptyList();
        }
    }
}
