package com.allomed.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class GuestSessionAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertGuestSessionAllPropertiesEquals(GuestSession expected, GuestSession actual) {
        assertGuestSessionAutoGeneratedPropertiesEquals(expected, actual);
        assertGuestSessionAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertGuestSessionAllUpdatablePropertiesEquals(GuestSession expected, GuestSession actual) {
        assertGuestSessionUpdatableFieldsEquals(expected, actual);
        assertGuestSessionUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertGuestSessionAutoGeneratedPropertiesEquals(GuestSession expected, GuestSession actual) {
        assertThat(actual)
            .as("Verify GuestSession auto generated properties")
            .satisfies(a -> assertThat(a.getId()).as("check id").isEqualTo(expected.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertGuestSessionUpdatableFieldsEquals(GuestSession expected, GuestSession actual) {
        assertThat(actual)
            .as("Verify GuestSession relevant properties")
            .satisfies(a -> assertThat(a.getSessionId()).as("check sessionId").isEqualTo(expected.getSessionId()))
            .satisfies(a -> assertThat(a.getCreatedAt()).as("check createdAt").isEqualTo(expected.getCreatedAt()))
            .satisfies(a -> assertThat(a.getLastActiveAt()).as("check lastActiveAt").isEqualTo(expected.getLastActiveAt()))
            .satisfies(a -> assertThat(a.getIpAddress()).as("check ipAddress").isEqualTo(expected.getIpAddress()))
            .satisfies(a -> assertThat(a.getUserAgent()).as("check userAgent").isEqualTo(expected.getUserAgent()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertGuestSessionUpdatableRelationshipsEquals(GuestSession expected, GuestSession actual) {
        // empty method
    }
}
