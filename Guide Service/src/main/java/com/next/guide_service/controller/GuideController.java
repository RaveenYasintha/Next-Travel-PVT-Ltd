package com.next.guide_service.controller;

import com.next.guide_service.entity.Guide;
import com.next.guide_service.service.GuideService;
import com.next.guide_service.utill.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/guide")
public class GuideController {

    @Autowired
    private GuideService guideService;

    @PostMapping(value = "/add_guide")
    public ResponseUtil addGuide(@RequestBody Guide guide) {
        return new ResponseUtil("OK", "Guide Added", guideService.addGuide(guide));
    }

    @PutMapping(value = "/update_guide")
    public ResponseUtil updateGuide(@RequestBody Guide guide) {
        return new ResponseUtil("OK", "Guide Updated", guideService.updateGuide(guide));
    }

    @DeleteMapping(value = "/del_guide")
    public ResponseUtil deleteGuide(@RequestParam String guideId) {
        guideService.deleteGuide(guideId);
        return new ResponseUtil("OK", "Guide Deleted", null);
    }

    @GetMapping(value = "/available")
    public ResponseUtil getAvailableGuide() {
        return new ResponseUtil("OK", "", guideService.getAvailableGuide());
    }

    @PutMapping(value = "/unavailable")
    public ResponseUtil setUnavailableGuide(@RequestParam String id) {
        guideService.setUnavailableGuide(id);
        return new ResponseUtil("OK", "", null);
    }

    @GetMapping(value = "/getGuide")
    public ResponseUtil getGuide() {
        return new ResponseUtil("OK", "Done", guideService.getAllGuide());
    }

    @GetMapping(value = "/get")
    public ResponseUtil getGuideById(@RequestParam String id) {
        return new ResponseUtil("OK", "Done", guideService.getGuideById(id));
    }
}
