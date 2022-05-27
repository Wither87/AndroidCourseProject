package com.example.data.models

import com.example.domain.models.Brand as DomainBrand
import com.example.domain.models.Phone as DomainPhone
import com.example.domain.models.PhoneDetails as DomainPhoneDetails
import com.example.domain.models.Specifications as DomainSpecifications
import com.example.domain.models.Specs as DomainSpecs

// Mappers for Brand classes
fun Brand.mapToDomain() : DomainBrand{
    return DomainBrand(
        Brand_id = this.Brand_id,
        Brand_name = this.Brand_name,
        Brand_slug = this.Brand_slug,
        Device_count = this.Device_count,
        Detail = this.Detail
    )
}

fun DomainBrand.mapToData() : Brand{
    return Brand(
        Brand_id = this.Brand_id,
        Brand_name = this.Brand_name,
        Brand_slug = this.Brand_slug,
        Device_count = this.Device_count,
        Detail = this.Detail
    )
}


// Mappers for Phone classes
fun Phone.mapToDomain() : DomainPhone{
    return DomainPhone(
        Brand=this.Brand,
        Phone_name=this.Phone_name,
        Slug=this.Slug,
        Image=this.Image,
        Detail=this.Detail
    )
}

fun DomainPhone.mapToData() : Phone{
    return Phone(
        Brand=this.Brand,
        Phone_name=this.Phone_name,
        Slug=this.Slug,
        Image=this.Image,
        Detail=this.Detail
    )
}


// Mappers for PhoneDetails classes
fun PhoneDetails.mapToDomain() : DomainPhoneDetails{
    val specifications = mutableListOf<DomainSpecifications>()
    for (spec in this.Specifications){
        specifications.add(spec.mapToDomain())
    }
    return DomainPhoneDetails(
        Brand=this.Brand,
        Phone_name=this.Phone_name,
        Thumbnail=this.Thumbnail,
        Phone_images=this.Phone_images,
        Release_date=this.Release_date,
        Dimension=this.Dimension,
        Os=this.Os,
        Storage=this.Storage,
        Specifications=specifications.toList()
    )
}

fun DomainPhoneDetails.mapToData() : PhoneDetails{
    val specifications = mutableListOf<Specifications>()
    for (spec in this.Specifications){
        specifications.add(spec.mapToData())
    }
    return PhoneDetails(
        Brand=this.Brand,
        Phone_name=this.Phone_name,
        Thumbnail=this.Thumbnail,
        Phone_images=this.Phone_images,
        Release_date=this.Release_date,
        Dimension=this.Dimension,
        Os=this.Os,
        Storage=this.Storage,
        Specifications=specifications.toList()
    )
}


// Mappers for Specifications classes
fun Specifications.mapToDomain() : DomainSpecifications{
    val specs = mutableListOf<DomainSpecs>()
    for (spec in this.Specs){
        specs.add(spec.mapToDomain())
    }
    return DomainSpecifications(
        Title=this.Title,
        Specs=specs.toList()
    )
}

fun DomainSpecifications.mapToData() : Specifications{
    val specs = mutableListOf<Specs>()
    for (spec in this.Specs){
        specs.add(spec.mapToData())
    }
    return Specifications(
        Title=this.Title,
        Specs=specs.toList()
    )
}


// Mappers for Specs classes
fun Specs.mapToDomain() : DomainSpecs{
    return DomainSpecs(
        Key=this.Key,
        Val=this.Val
    )
}

fun DomainSpecs.mapToData() : Specs{
    return Specs(
        Key=this.Key,
        Val=this.Val
    )
}