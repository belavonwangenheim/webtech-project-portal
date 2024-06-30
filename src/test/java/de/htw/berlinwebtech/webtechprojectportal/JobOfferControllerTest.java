package de.htw.berlinwebtech.webtechprojectportal.web.controller;

import de.htw.berlinwebtech.webtechprojectportal.service.JobOfferService;
import de.htw.berlinwebtech.webtechprojectportal.web.JobOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobOfferControllerTest {

    @InjectMocks
    private JobOfferController jobOfferController;

    @Mock
    private JobOfferService jobOfferService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllJobs() {
        List<JobOffer> mockJobOffers = List.of(new JobOffer(), new JobOffer());
        when(jobOfferService.getAllJobs()).thenReturn(mockJobOffers);

        List<JobOffer> result = jobOfferController.getAllJobs();
        assertEquals(2, result.size());
    }

    @Test
    void testGetJobById() {
        JobOffer mockJobOffer = new JobOffer();
        when(jobOfferService.getJobById(1L)).thenReturn(Optional.of(mockJobOffer));

        ResponseEntity<JobOffer> response = jobOfferController.getJobById(1L);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(mockJobOffer, response.getBody());
    }

    @Test
    void testGetJobByIdNotFound() {
        when(jobOfferService.getJobById(1L)).thenReturn(Optional.empty());

        ResponseEntity<JobOffer> response = jobOfferController.getJobById(1L);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void testCreateJob() {
        JobOffer mockJobOffer = new JobOffer();
        when(jobOfferService.createJob(any(JobOffer.class))).thenReturn(mockJobOffer);

        JobOffer result = jobOfferController.createJob(mockJobOffer);
        assertEquals(mockJobOffer, result);
    }

    @Test
    void testDeleteJob() {
        doNothing().when(jobOfferService).deleteJob(1L);

        jobOfferController.deleteJob(1L);
        verify(jobOfferService, times(1)).deleteJob(1L);
    }

    @Test
    void testUpdateJob() {
        JobOffer mockJobOffer = new JobOffer();
        when(jobOfferService.updateJob(eq(1L), any(JobOffer.class))).thenReturn(Optional.of(mockJobOffer));

        ResponseEntity<JobOffer> response = jobOfferController.updateJob(1L, mockJobOffer);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(mockJobOffer, response.getBody());
    }

    @Test
    void testUpdateJobNotFound() {
        when(jobOfferService.updateJob(eq(1L), any(JobOffer.class))).thenReturn(Optional.empty());

        ResponseEntity<JobOffer> response = jobOfferController.updateJob(1L, new JobOffer());
        assertTrue(response.getStatusCode().is4xxClientError());
    }
}
