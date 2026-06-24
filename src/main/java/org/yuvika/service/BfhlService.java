package org.yuvika.service;

import org.yuvika.dto.BfhlRequest;
import org.yuvika.dto.BfhlResponse;

public interface BfhlService {

    BfhlResponse process(BfhlRequest request);

}