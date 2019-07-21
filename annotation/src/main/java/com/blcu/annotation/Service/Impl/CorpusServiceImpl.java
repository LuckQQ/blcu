package com.blcu.annotation.Service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blcu.annotation.Dao.CorpusRepository;
import com.blcu.annotation.Entity.Corpus;
import com.blcu.annotation.Service.CorpusService;
import com.blcu.annotation.util.StringUtil;

@Service
public class CorpusServiceImpl implements CorpusService {

	@Autowired
	private CorpusRepository corpusRepository;
	
	@Override
	public void addCorpus(Corpus corpus) {
		corpusRepository.save(corpus);
	}

	@Override
	public Map<String, List<String>> cutOriginalCorpus(String corpusId) {
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
		List<String> words = new ArrayList<String>();
		List<String> tags = new ArrayList<String>();
		
		String corpus = "[0]Root/Root [1]三/m [2]名/q [3]女    / //子/n [4]在/p [5]沙//////////滩/n [6]上/nd [7]手/n [8]牵/v [9]手/n [10]。/wp";
		String wordArr[] = corpus.split(" \\[");     // 避免 word 中出现空格的情况
		
		for (int i = 0; i < wordArr.length; i++) {
			System.out.println(wordArr[i]);
			
			String slide[] = wordArr[i].split("]")[1].split("/");         
			String tag = slide[slide.length-1];
			String word = "";
			if(StringUtil.isBlank(slide[0])){
				continue;
			}else {
				word = slide[0];
			}
			 
			for(int j =1; j<slide.length-1; j++){           // 避免 word 当中可能有“/”的情况
				if(slide[j] == ""){
					word += "/";
				}else{
					word += "/" + slide[j];
				}
			}
			
			words.add(word);
			tags.add(tag);
		}
		resultMap.put("words", words);
		resultMap.put("tags", tags);
		return resultMap;
	}

	@Override
	public List<String> getWords(String corpus) {
		List<String> words = new ArrayList<String>();
		String wordArr[] = corpus.split(" \\["); 
		
		for (int i = 0; i < wordArr.length; i++) {
			String slide[] = wordArr[i].split("]")[1].split("/");         
			String word = null;
			if(StringUtil.isBlank(slide[0])){
				continue;
			}else {
				word = slide[0];
			}
			 
			for(int j =1; j<slide.length-1; j++){           // 避免 word 当中可能有“/”的情况
				if(slide[j] == ""){
					word += "/";
				}else{
					word += "/" + slide[j];
				}
			}
			
			words.add(word);
		}
		return words;
	}

	@Override
	public List<String> getTags(String corpus) {
		List<String> tags = new ArrayList<String>();
		String wordArr[] = corpus.split(" \\[");     // 避免 word 中出现空格的情况
		
		for (int i = 0; i < wordArr.length; i++) {
			String slide[] = wordArr[i].split("]")[1].split("/");         
			String tag = null;
			if(StringUtil.isBlank(slide[0])){
				continue;
			}else {
				tag = slide[slide.length-1];

			}
			tags.add(tag);
		}
		return tags;
	}

	@Override
	public List<Integer> getWidth(List<String> words, Integer fontSize) {
		List<Integer> widths = new ArrayList<Integer>();
		int size = words.size();
		for (int i = 0; i < size; i++) {
			int len  = words.get(i).length();
			widths.add(len * fontSize);
		}
		return widths;
	}

	@Override
	public List<Map<String, String>> getRelations(String machineCorpus) {
		List<Map<String, String>> relations = new ArrayList<Map<String,String>>();
		
		String words[] = machineCorpus.split("\\t");
        
		for(int i = 0; i< words.length; i++){
			if (StringUtil.isBlank(words[i])) {
				continue;
			}
			Map<String, String> relationMap = new HashMap<String, String>();
			String temp1 = words[i];
			System.out.println(temp1);
			String tmp2[] = temp1.split("\\[");
			String start = tmp2[1].split("\\]")[0];
			String end= tmp2[2].split("\\]")[0];
            System.out.println(start + "   " + end);
			String relation = temp1.substring(temp1.lastIndexOf("(")+ 1, temp1.lastIndexOf(")") ); 
			System.out.println("relation:" + relation);
			
			relationMap.put("start", start);
			relationMap.put("end", end);
			relations.add(relationMap);
		}
		return relations;
	}

}
