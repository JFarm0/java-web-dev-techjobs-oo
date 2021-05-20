package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;

    @Before
    public void createJobObject() {
        test_job1 = new Job();
        test_job2 = new Job();
    }

    @Test
    public void emptyTest() {
        assertEquals(10, 10);
    }

    @Test
    public void testSettingJobId() {
        assertEquals(test_job1.getId(), (test_job2.getId()-1));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test_job3.getId() == (int)test_job3.getId());
        assertTrue(test_job3.getName().equals("Product tester"));
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getEmployer().toString().equals("ACME"));
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getLocation().toString().equals("Desert"));
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getPositionType().toString().equals("Quality control"));
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(test_job3.getCoreCompetency().toString().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality() {
        Job test_job4 = new Job("Tester", new Employer("IBM"), new Location("Seattle"), new PositionType("QA"), new CoreCompetency("Communication"));
        Job test_job5 = new Job("Tester", new Employer("IBM"), new Location("Seattle"), new PositionType("QA"), new CoreCompetency("Communication"));
        assertFalse(test_job4.getId() == test_job5.getId());
    }

    @Test
    public void testJobToString() {
        Job test_job6 = new Job("CEO", new Employer("Apple"), new Location("Moon"), new PositionType("Executive"), new CoreCompetency("Inspiration"));
        assertTrue(test_job6.toString().equals("\n" +
                "ID: 3" +
                "\nName: CEO" +
                "\nEmployer: Apple" +
                "\nLocation: Moon" +
                "\nPosition Type: Executive" +
                "\nCore Competency: Inspiration" +
                "\n"));
    }

    @Test
    public void testJobToStringWithEmpty() {
        Job test_job7 = new Job("Job name", new Employer("Company"), new Location("Amsterdam"), new PositionType(""), new CoreCompetency(""));
        assertTrue(test_job7.toString().equals("\n" +
                "ID: 3" +
                "\nName: Job name" +
                "\nEmployer: Company" +
                "\nLocation: Amsterdam" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available" +
                "\n"));
    }
}
