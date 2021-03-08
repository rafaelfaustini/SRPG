package br.com.rafaelfaustini.srpg.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampaignTest {

    private Campaign campaign;

    @BeforeEach
    void setUp() {
        campaign = new Campaign(22, "campaignName", "campaignStory");
    }

    @AfterEach
    void tearDown() {
        campaign = null;
    }

    @Test
    void getId() {
        assertEquals(22, campaign.getId());
    }

    @Test
    void getName() {
        assertEquals("campaignName", campaign.getName());
    }

    @Test
    void setName() {
        campaign.setName("newCampaignName");
        assertEquals("newCampaignName", campaign.getName());

    }

    @Test
    void getStory() {
        assertEquals("campaignStory", campaign.getStory());
    }

    @Test
    void setStory() {
        campaign.setStory("newCampaignStory");
        assertEquals("newCampaignStory", campaign.getStory());
    }
}