package com.allomed.app.repository;

import com.allomed.app.domain.DoctorProfile;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface DoctorProfileRepositoryWithBagRelationships {
    Optional<DoctorProfile> fetchBagRelationships(Optional<DoctorProfile> doctorProfile);

    List<DoctorProfile> fetchBagRelationships(List<DoctorProfile> doctorProfiles);

    Page<DoctorProfile> fetchBagRelationships(Page<DoctorProfile> doctorProfiles);
}
