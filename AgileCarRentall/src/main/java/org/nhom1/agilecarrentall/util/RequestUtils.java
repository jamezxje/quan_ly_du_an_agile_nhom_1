package org.nhom1.agilecarrentall.util;

import org.nhom1.agilecarrentall.entity.Member;
import org.springframework.ui.Model;

public class RequestUtils {

    public static Member getMemberFromModel(Model model) {
        return (Member) model.getAttribute("member");
    }
}
