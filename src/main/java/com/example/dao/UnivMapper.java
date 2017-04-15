package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.example.model.ProdiModel;
import com.example.model.UnivModel;

@Mapper
public interface UnivMapper {

	@Select("SELECT kode_univ, nama_univ, url_univ FROM univ WHERE kode_univ = #{kode_univ}")
	@Results(value={
    		@Result(property="kode_univ", column="kode_univ"),
    		@Result(property="nama_univ", column="nama_univ"),
    		@Result(property="url_univ", column="url_univ"),
    		@Result(property="prodis", column="kode_univ",
    		javaType = List.class, many=@Many(select="selectProdis"))
    })
	UnivModel selectUniv(@Param("kode_univ") String kode_univ);

	@Select("SELECT kode_univ, nama_univ, url_univ FROM univ")
    @Results(value={
    		@Result(property="kode_univ", column="kode_univ"),
    		@Result(property="nama_univ", column="nama_univ"),
    		@Result(property="url_univ", column="url_univ"),
    		@Result(property="prodis", column="kode_univ",
    		javaType = List.class, many=@Many(select="selectProdis"))
    })
	List<UnivModel> selectAllUniv();
	
	
	@Select("SELECT p.kode_prodi, p.nama_prodi "
			+ "FROM prodi p JOIN univ u "
			+ "ON p.kode_univ=u.kode_univ "
			+ "WHERE u.kode_univ=#{kode_univ}")
    List<ProdiModel> selectProdis (@Param("kode_univ") String kode_univ);

	@Insert("INSERT INTO prodi (kode_univ, nama_univ, url_univ) VALUES (#{kode_univ}, #{nama_univ}, #{url_univ})")
	void addUniv(UnivModel univ);

	@Delete("Delete from univ where kode_univ=#{kode_univ}")
	void deleteUniv(@Param("kode_univ") String kode_univ);

	@Update("Update univ set kode_univ=#{univ.kode_univ}, nama_univ=#{univ.nama_univ}, url_univ=#{univ.url_univ} where kode_univ=#{univ.kode_univ};")
	void updateUniv(@Param("univ") UnivModel univ);

}
