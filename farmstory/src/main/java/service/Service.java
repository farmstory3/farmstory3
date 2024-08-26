package service;

import dto.responsedto.ResponseDto;

public interface Service<T> {
    ResponseDto handleService(T requestDto);
    
}