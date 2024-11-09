package com.backend.empowerpro.utils;

import com.backend.empowerpro.dto.leave.LeaveCreationDto;
import com.backend.empowerpro.dto.leave.LeaveDto;
import com.backend.empowerpro.entity.Leave;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveMapper {
    LeaveDto toLeaveDto(Leave leave);
    Leave toLeave(LeaveCreationDto leaveCreationDto);
}
