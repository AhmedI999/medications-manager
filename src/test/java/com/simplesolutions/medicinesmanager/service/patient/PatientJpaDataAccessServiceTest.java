package com.simplesolutions.medicinesmanager.service.patient;

import com.github.javafaker.Faker;
import com.simplesolutions.medicinesmanager.model.Patient;
import com.simplesolutions.medicinesmanager.repository.PatientRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@FieldDefaults(level = AccessLevel.PRIVATE)
class PatientJpaDataAccessServiceTest {
    private PatientJpaDataAccessService patientJpaTest;
    Patient patient;
    private Faker faker;
    @Mock
    private PatientRepository patientRepository;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        patientJpaTest = new PatientJpaDataAccessService(patientRepository);
        faker = new Faker();
        patient = Patient.builder()
                .email(faker.internet().safeEmailAddress() + "-" + UUID.randomUUID())
                .password(faker.internet().password())
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .age(faker.number().randomDigitNotZero())
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @DisplayName("Verify that selectAllPatients() can invoke findAll()")
    void selectAllPatients() {
        //When
        patientJpaTest.selectAllPatients();
        //Then
        verify(patientRepository).findAll();
    }

    @Test
    @DisplayName("Verify that selectPatientById() can invoke findById()")
    void selectPatientById() {
        // Given
        int id = 1;
        when(patientRepository.findById(id)).thenReturn(Optional.of(patient));
        //When
        Optional<Patient> actual = patientJpaTest.selectPatientById(id);
        //Then
        verify(patientRepository).findById(id);
        assertThat(Optional.of(patient)).isEqualTo(actual);
    }


    @Test
    @DisplayName("Verify that savePatient() can invoke save()")
    void savePatient() {
        //When
        patientJpaTest.savePatient(patient);
        //Then
        verify(patientRepository).save(patient);
    }

    @Test
    @DisplayName("Verify that doesPatientExists invokes existsPatientByEmail()")
    void doesPatientExists() {
        // Given
        String email = faker.internet().emailAddress();
        //When
        patientJpaTest.doesPatientExists(email);
        //Then
        verify(patientRepository).existsPatientByEmail(email);
    }

    @Test
    @DisplayName("Verify that deletePatientById() can invoke delete()")
    void deletePatientById() {
        // Given
        when(patientRepository.findById(patient.getId()))
                .thenReturn(Optional.of(patient));
        //When
        patientJpaTest.deletePatientById(patient.getId());
        //Then
        verify(patientRepository).delete(patient);
    }

    @Test
    @DisplayName("Verify that updatePatient() can update and invoke save()")
    void updatePatient() {
        // Given
        String newEmail = "Larry@example.com";
        patient.setEmail(newEmail);
        //When
        patientJpaTest.updatePatient(patient);
        //Then
        verify(patientRepository).save(patient);
        assertThat(patient.getEmail()).isEqualTo(newEmail);

    }
}