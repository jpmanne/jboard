package com.ais.jb.util;

import java.util.List;

import com.ais.jb.dao.model.UserDetails;

public class AppUtil {

	//=========================================================================
	
	public static String getUserFullName(List<UserDetails> users, long userDetailsId) {
		for(UserDetails ud  : users) {
			if(userDetailsId == ud.getUserDetailsId()) {
				String fullName = ud.getFirstName();
				if(ud.getMiddleName() != null && ud.getMiddleName().trim().length() > 0) {
					fullName = fullName.concat(" ").concat(ud.getMiddleName());
				}
				fullName = fullName.concat(" ").concat(ud.getLastName());
				return fullName;
			}
		}
		return "";
	}
	
	//=========================================================================
}
