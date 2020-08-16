package com.kulak.youtubemock.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
class CORSFilter(source: CorsConfigurationSource) : CorsFilter(source) {
    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) =
            response.run {
                addHeader("Access-Control-Allow-Headers",
                        "Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, Content-Type, " +
                                "Access-Control-Request-Method, Access-Control-Request-Headers")
                if (getHeader("Access-Control-Allow-Origin") == null)
                    addHeader("Access-Control-Allow-Origin", "*")
                filterChain.doFilter(request, this)
            }
}