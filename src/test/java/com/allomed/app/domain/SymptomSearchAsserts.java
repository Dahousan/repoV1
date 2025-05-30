package com.allomed.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class SymptomSearchAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSymptomSearchAllPropertiesEquals(SymptomSearch expected, SymptomSearch actual) {
        assertSymptomSearchAutoGeneratedPropertiesEquals(expected, actual);
        assertSymptomSearchAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSymptomSearchAllUpdatablePropertiesEquals(SymptomSearch expected, SymptomSearch actual) {
        assertSymptomSearchUpdatableFieldsEquals(expected, actual);
        assertSymptomSearchUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSymptomSearchAutoGeneratedPropertiesEquals(SymptomSearch expected, SymptomSearch actual) {
        assertThat(actual)
            .as("Verify SymptomSearch auto generated properties")
            .satisfies(a -> assertThat(a.getId()).as("check id").isEqualTo(expected.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSymptomSearchUpdatableFieldsEquals(SymptomSearch expected, SymptomSearch actual) {
        assertThat(actual)
            .as("Verify SymptomSearch relevant properties")
            .satisfies(a -> assertThat(a.getSearchDate()).as("check searchDate").isEqualTo(expected.getSearchDate()))
            .satisfies(a -> assertThat(a.getSymptoms()).as("check symptoms").isEqualTo(expected.getSymptoms()))
            .satisfies(a -> assertThat(a.getAiResponseJson()).as("check aiResponseJson").isEqualTo(expected.getAiResponseJson()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSymptomSearchUpdatableRelationshipsEquals(SymptomSearch expected, SymptomSearch actual) {
        assertThat(actual)
            .as("Verify SymptomSearch relationships")
            .satisfies(a -> assertThat(a.getUser()).as("check user").isEqualTo(expected.getUser()))
            .satisfies(a -> assertThat(a.getGuestSession()).as("check guestSession").isEqualTo(expected.getGuestSession()));
    }
}
