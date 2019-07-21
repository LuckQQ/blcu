package com.blcu.annotation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blcu.annotation.util.StringUtil;

@RestController
public class CorpusController {

	
	@RequestMapping(value = "/getCorpus")
	public String getCorpus(Integer corpusId, Integer fontSize) {
		
		
		return null;
	}
	
	
	
	
	public static void main(String[] args) {
		String machineSent = "[2]名_[1]三(Quan)		[3]女子_[2]名(Qp)		[8]牵_[3]女子(Agt)		[5]沙滩_[4]在(mPrep)		[8]牵_[5]沙滩(Loc)		[5]沙滩_[6]上(mRang)		[8]牵_[7]手(Tool)		[0]Root_[8]牵(Root)		[8]牵_[9]手(Pat)		[8]牵_[10]。(mPunc)";
		String words[] = machineSent.split("\\t");
        
		for(int i = 0; i< words.length; i++){

			if (StringUtil.isBlank(words[i])) {
				continue;
			}
			String temp1 = words[i];
			System.out.println(temp1);
			String tmp2[] = temp1.split("\\[");
			String start = tmp2[1].split("\\]")[0];
			String end= tmp2[2].split("\\]")[0];
            System.out.println(start + "   " + end);
			String relation = temp1.substring(temp1.lastIndexOf("(")+ 1, temp1.lastIndexOf(")") ); 
			System.out.println("relation:" + relation);
		}
	}
}
