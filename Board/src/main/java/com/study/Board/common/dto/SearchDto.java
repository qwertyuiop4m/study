package com.study.Board.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchDto {
    private int page; //현재 페이지 번호
    private int recordSize; // 페이자당 출력할 데이터 게수
    private int pagaSize; //화면 하단에 출력할 페이지 사이즈
    private String keyword; // 검색 키워드
    private String searchType; //검색 유형

    public SearchDto(){
        this.page=1;
        this.recordSize=10;
        this.pagaSize=10;
    }

    public int getOffset(){
        return (page-1)*recordSize;
    }
}
