package org.nhom1.agilecarrentall.service.common;

import org.nhom1.agilecarrentall.entity.SystemOption;
import org.nhom1.agilecarrentall.entity.dto.common.SystemOptionResponseDTO;

import java.util.List;

public interface SystemOptionService {

    List<SystemOption> getAllSystemOption();

    void saveSystemOption(SystemOption systemOption);

    void updateSystemOption(String optionKey, String optionValue);

    void updateMoneyRelatedOption(String optionKey, String valueToAdd);

    SystemOption findSystemOptionById(Integer id);

    void deleteSystemOptionById(Integer id);

    String findSystemOptionValueByKey(String optionKey);

    List<SystemOptionResponseDTO> getAllFrontSystemOption();

}
