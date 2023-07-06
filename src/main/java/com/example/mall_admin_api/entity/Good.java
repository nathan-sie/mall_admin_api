package com.example.mall_admin_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName good
 */
@TableName(value ="good")
@Data
public class Good implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 
     */
    private String code;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private Integer characteristic;

    /**
     * 
     */
    private String batch;

    /**
     * 
     */
    private String pic;

    /**
     * 
     */
    private Integer stock;

    /**
     * 
     */
    private BigDecimal buyPrice;

    /**
     * 
     */
    private BigDecimal standardPrice;

    /**
     * 
     */
    private BigDecimal currentPrice;

    /**
     * 
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;

    /**
     * 
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date deadline;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Good() {
    }

    public Good(String id, String code, String name, String type, Integer characteristic, String batch, String pic, Integer stock, BigDecimal buyPrice, BigDecimal standardPrice, BigDecimal currentPrice, Date createDate, Date deadline) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.characteristic = characteristic;
        this.batch = batch;
        this.pic = pic;
        this.stock = stock;
        this.buyPrice = buyPrice;
        this.standardPrice = standardPrice;
        this.currentPrice = currentPrice;
        this.createDate = createDate;
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Good other = (Good) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCharacteristic() == null ? other.getCharacteristic() == null : this.getCharacteristic().equals(other.getCharacteristic()))
            && (this.getBatch() == null ? other.getBatch() == null : this.getBatch().equals(other.getBatch()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getBuyPrice() == null ? other.getBuyPrice() == null : this.getBuyPrice().equals(other.getBuyPrice()))
            && (this.getStandardPrice() == null ? other.getStandardPrice() == null : this.getStandardPrice().equals(other.getStandardPrice()))
            && (this.getCurrentPrice() == null ? other.getCurrentPrice() == null : this.getCurrentPrice().equals(other.getCurrentPrice()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCharacteristic() == null) ? 0 : getCharacteristic().hashCode());
        result = prime * result + ((getBatch() == null) ? 0 : getBatch().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getBuyPrice() == null) ? 0 : getBuyPrice().hashCode());
        result = prime * result + ((getStandardPrice() == null) ? 0 : getStandardPrice().hashCode());
        result = prime * result + ((getCurrentPrice() == null) ? 0 : getCurrentPrice().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", characteristic=").append(characteristic);
        sb.append(", batch=").append(batch);
        sb.append(", pic=").append(pic);
        sb.append(", stock=").append(stock);
        sb.append(", buyPrice=").append(buyPrice);
        sb.append(", standardPrice=").append(standardPrice);
        sb.append(", currentPrice=").append(currentPrice);
        sb.append(", createDate=").append(createDate);
        sb.append(", deadline=").append(deadline);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}