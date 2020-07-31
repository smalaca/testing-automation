package com.smalaca.testsuite;

import java.util.List;

interface TestSuiteRepository {
    void save(TestSuite testSuite, Author author);

    boolean existsFor(Author author);

    List<TestSuite> findAllFor(Author author);
}
