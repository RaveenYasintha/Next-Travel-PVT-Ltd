package com.next.guide_service.service.impl;

import com.next.guide_service.entity.Guide;
import com.next.guide_service.repository.GuideRepository;
import com.next.guide_service.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideRepository guideRepository;

    @Override
    public Guide addGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    @Override
    public Guide updateGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    @Override
    public void deleteGuide(String guideId) {
        guideRepository.deleteById(guideId);
    }

    @Override
    public Guide getAvailableGuide() {
        List<Guide> guideList = guideRepository.findFirstByStatus();
        if (guideList.isEmpty()) {
            throw new RuntimeException("There is no available guide at this moment");
        }
        Guide returningGuide = guideList.get(0);
        return returningGuide;
    }

    @Override
    public void setUnavailableGuide(String id) {
        Guide guide = getGuideById(id);
        guide.setStatus("Unavailable");
        guideRepository.save(guide);
    }

    @Override
    public List<Guide> getAllGuide() {
        return guideRepository.findAll();
    }

    @Override
    public Guide getGuideById(String id) {
        return guideRepository.findById(id).get();
    }
}
