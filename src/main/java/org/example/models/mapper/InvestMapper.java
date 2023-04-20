package org.example.models.mapper;

import org.example.models.Invest;
import org.example.models.dto.InvestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface InvestMapper {

    @Mapping(source= "month_ref", target ="month_ref")
    Invest investDTOtoInvest(InvestDTO invest);
}
