package br.com.sankhya.knowledgebasefinder.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDTO {

	private List<String> tag;
	private String title;
	private String highlight;
	
}
