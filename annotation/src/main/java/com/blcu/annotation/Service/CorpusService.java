package com.blcu.annotation.Service;

import java.util.List;
import java.util.Map;

import com.blcu.annotation.Entity.Corpus;


public interface CorpusService {
	
	public void addCorpus(Corpus corpus);
	
	public Map<String, List<String>> cutOriginalCorpus(String corpusId);
	
	public List<String> getWords(String corpus);
	
	public List<String> getTags(String corpus);
	
	public List<Integer> getWidth(List<String> words, Integer fontSize);
	
	public List<Map<String, String>> getRelations(String machineCorpus);
}
