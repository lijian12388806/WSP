<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<!--[if IE]>
<object id="mediaplayer" type="video/x-ms-wmv"  width=300 height=250 classid="clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6"> 
<param name="url" value="${url}" valuetype="ref" type="video/x-ms-wmv"> 
<param name="rate" value="1">
        <param name="balance" value="0">
        <param name="currentPosition" value="0">
        <param name="defaultFrame" value>
        <param name="playCount" value="1">
        <param name="autoStart" value="1">
        <param name="currentMarker" value="0">
        <param name="invokeURLs" value="1">
        <param name="baseURL" value>
        <param name="volume" value="100" id="volume">
        <param name="mute" value="0">
        <param name="uiMode" value="full">
        <param name="stretchToFit" value="0">
        <param name="windowlessVideo" value="0">
        <param name="enabled" value="1">
        <param name="enableContextMenu" value="-1">
        <param name="fullScreen" value="0">
        <param name="SAMIStyle" value>
        <param name="SAMILang" value>
        <param name="SAMIFilename" value>
        <param name="captioningID" value>
        <param name="enableErrorDialogs" value="0">
        <param name="_cx" value="7779">
        <param name="_cy" value="1693">
<strong>Error:</strong>You need <a href="http://www.microsoft.com/windows/windowsmedia/download/plugin.aspx">Windows Media Player Plugin</a>. 
</object> 
<![endif]-->
<!--[if !IE]><!-->
<object id="mediaplayer" type="application/x-ms-wmp" data="path" width=300 height=250> 
<param name="src" value="${url}" valuetype="ref" type="video/x-ms-wmp"> 
<param name="rate" value="1">
        <param name="balance" value="0">
        <param name="currentPosition" value="0">
        <param name="defaultFrame" value>
        <param name="playCount" value="1">
        <param name="autoStart" value="1">
        <param name="currentMarker" value="0">
        <param name="invokeURLs" value="1">
        <param name="baseURL" value>
        <param name="volume" value="100" id="volume">
        <param name="mute" value="0">
        <param name="uiMode" value="full">
        <param name="stretchToFit" value="0">
        <param name="windowlessVideo" value="0">
        <param name="enabled" value="1">
        <param name="enableContextMenu" value="-1">
        <param name="fullScreen" value="0">
        <param name="SAMIStyle" value>
        <param name="SAMILang" value>
        <param name="SAMIFilename" value>
        <param name="captioningID" value>
        <param name="enableErrorDialogs" value="0">
        <param name="_cx" value="7779">
        <param name="_cy" value="1693">
<strong>Error:</strong>You need <a href="http://port25.technet.com/pages/windows-media-player-firefox-plugin-download.aspx">Windows Media Player Plugin</a>.
</object> 
<!--<![endif]-->
</div>
