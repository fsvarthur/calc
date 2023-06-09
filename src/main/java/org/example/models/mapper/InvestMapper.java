package org.example.models.mapper;

import org.example.models.Invest;
import org.example.models.dto.InvestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface InvestMapper {

    @Mapping(source= "month_ref", target ="month_ref")
    Invest investDTOtoInvest(InvestDTO invest);

    @Mapping(source = "month_ref", target = "month_ref")
    InvestDTO investToInvestDTO(Invest invest);

    @Mapping(source = "month_ref", target = "month_ref")
    List<InvestDTO> investToInvestDTO(List<Invest> investmentsById);
}
