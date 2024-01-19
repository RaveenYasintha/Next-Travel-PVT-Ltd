package com.next.guide_service.service;

import com.next.guide_service.entity.Guide;

import java.util.List;

public interface GuideService {

    Guide addGuide(Guide guide);
    Guide updateGuide(Guide guide);
    void deleteGuide(String guideId);
    Guide getAvailableGuide();
    void setUnavailableGuide(String id);
    List<Guide> getAllGuide();
    Guide getGuideById(String id);
}
