package com.omar.gestiondestock.dto;

import com.omar.gestiondestock.model.Article;
import com.omar.gestiondestock.model.LigneVente;
import com.omar.gestiondestock.model.MvtStk;
import com.omar.gestiondestock.model.TypeMvtStk;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtStkDto {

    private Integer id;

    private Instant datMvt;

    private BigDecimal quantite;

    private ArticleDto article;

    private TypeMvtStkDto typeMvt;


    public static MvtStkDto fromEntity(MvtStk mvtStk){
        if (mvtStk == null){
            return null;
        }
        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .datMvt(mvtStk.getDatMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(TypeMvtStkDto.fromEntity(mvtStk.getTypeMvt()))
                .build();

    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto){
        if(mvtStkDto == null){
            return null;
        }

        MvtStk mvtStk  = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setDatMvt(mvtStkDto.getDatMvt());
        mvtStk.setQuantite(mvtStkDto.getQuantite());


        return mvtStk;
    }
}
