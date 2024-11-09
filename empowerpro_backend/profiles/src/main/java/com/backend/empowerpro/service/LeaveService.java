package com.backend.empowerpro.service;

import com.backend.empowerpro.dto.leave.LeaveCreationDto;
import com.backend.empowerpro.dto.leave.LeaveDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface LeaveService {
    public List<LeaveDto> getAllLeaves();
    public String createLeave(LeaveCreationDto leaveCreationDto);
    public LeaveDto getOneLeave(Long id);
    public LeaveDto updateLeave(Long id,LeaveCreationDto leaveCreationDto);
    public String deleteLeave(Long id);
    public List<LeaveDto> getLeavesByFilter(String timePeriod,String status);
}
