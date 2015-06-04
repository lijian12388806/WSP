window.attachEvent("onload", function() {
	top.aic_initialMe(aic_initialAfterPhoneFinished);
});

function aic_initialAfterPhoneFinished() {
	if (!window.phone)
		window.phone = top.phone;
	if (!window.aic)
		window.aic = top.phone.aic;
	if (!window.config)
		window.config = top.phone.config;
	if (!window.teleEventType)
		window.teleEventType = top.phone.teleEventType;
	if (!window.teleEnum)
		window.teleEnum = top.phone.teleEnum;
	if (!window.listen)
		window.listen = top.phone.listen;

	if (window.initPhone)
		initPhone();
	if (window.allEvent)
		listen("all", allEvent);
	if (window.EventAbandoned)
		listen(teleEventType._Abandoned, EventAbandoned);
	if (window.EventAttributesChanged)
		listen(teleEventType._AttributesChanged, EventAttributesChanged);
	if (window.EventAudioSourceChanged)
		listen(teleEventType._AudioSourceChanged, EventAudioSourceChanged);
	if (window.EventConnectionStatusChanged)
		listen(teleEventType._ConnectionStatusChanged,
				EventConnectionStatusChanged);
	if (window.EventContactAttributesChanged)
		listen(teleEventType._ContactAttributesChanged,
				EventContactAttributesChanged);
	if (window.EventCurrentContextChanged)
		listen(teleEventType._CurrentContextChanged, EventCurrentContextChanged);
	if (window.EventDeliveryStatusChanged)
		listen(teleEventType._DeliveryStatusChanged, EventDeliveryStatusChanged);
	if (window.EventDestinationBusy)
		listen(teleEventType._DestinationBusy, EventDestinationBusy);
	if (window.EventDestinationConnected)
		listen(teleEventType._DestinationConnected, EventDestinationConnected);
	if (window.EventDiverted)
		listen(teleEventType._Diverted, EventDiverted);
	if (window.EventFindAgentsResponse)
		listen(teleEventType._FindAgentsResponse, EventFindAgentsResponse);
	if (window.EventFindQueuesResponse)
		listen(teleEventType._FindQueuesResponse, EventFindQueuesResponse);
	if (window.EventHealthStatusChanged)
		listen(teleEventType._HealthStatusChanged, EventHealthStatusChanged);
	if (window.EventLastAuxReasonCodeChanged)
		listen(teleEventType._LastAuxReasonCodeChanged,
				EventLastAuxReasonCodeChanged);
	if (window.EventChannelOperationFailed)
		listen(teleEventType._ChannelOperationFailed,
				EventChannelOperationFailed);
	if (window.EventEmailDraftOperationFailed)
		listen(teleEventType._EmailDraftOperationFailed,
				EventEmailDraftOperationFailed);
	if (window.EventMediaInteractionOperationFailed)
		listen(teleEventType._MediaInteractionOperationFailed,
				EventMediaInteractionOperationFailed);
	if (window.EventSessionOperationFailed)
		listen(teleEventType._SessionOperationFailed,
				EventSessionOperationFailed);
	if (window.EventVoiceMediaInteractionOperationFailed)
		listen(teleEventType._VoiceMediaInteractionOperationFailed,
				EventVoiceMediaInteractionOperationFailed);
	if (window.EventWorkItemOperationFailed)
		listen(teleEventType._WorkItemOperationFailed,
				EventWorkItemOperationFailed);
	if (window.EventEmailDraftOperationSucceeded)
		listen(teleEventType._EmailDraftOperationSucceeded,
				EventEmailDraftOperationSucceeded);
	if (window.EventMediaInteractionOperationSucceeded)
		listen(teleEventType._MediaInteractionOperationSucceeded,
				EventMediaInteractionOperationSucceeded);
	if (window.EventSessionOperationSucceeded)
		listen(teleEventType._SessionOperationSucceeded,
				EventSessionOperationSucceeded);
	if (window.EventWorkItemOperationSucceeded)
		listen(teleEventType._WorkItemOperationSucceeded,
				EventWorkItemOperationSucceeded);
	if (window.EventPartyAdded)
		listen(teleEventType._PartyAdded, EventPartyAdded);
	if (window.EventPartyDropped)
		listen(teleEventType._PartyDropped, EventPartyDropped);
	if (window.EventRequestCustomerHistoryResponse)
		listen(teleEventType._RequestCustomerHistoryResponse,
				EventRequestCustomerHistoryResponse);
	if (window.EventRequestEmailMessageResponse)
		listen(teleEventType._RequestEmailMessageResponse,
				EventRequestEmailMessageResponse);
	if (window.EventRequestHistoryResponse)
		listen(teleEventType._RequestHistoryResponse,
				EventRequestHistoryResponse);
	if (window.EventRequestTranscriptResponse)
		listen(teleEventType._RequestTranscriptResponse,
				EventRequestTranscriptResponse);
	if (window.EventRequestWorkItemHistoryResponse)
		listen(teleEventType._RequestWorkItemHistoryResponse,
				EventRequestWorkItemHistoryResponse);
	if (window.EventRequestWrapupRecordsResponse)
		listen(teleEventType._RequestWrapupRecordsResponse,
				EventRequestWrapupRecordsResponse);
	if (window.EventRONA)
		listen(teleEventType._RONA, EventRONA);
	if (window.EventShutdown)
		listen(teleEventType._Shutdown, EventShutdown);
	if (window.EventChannelStateChanged)
		listen(teleEventType._ChannelStateChanged, EventChannelStateChanged);
	if (window.EventSessionStateChanged)
		listen(teleEventType._SessionStateChanged, EventSessionStateChanged);
	if (window.EventWorkItemStateChanged)
		listen(teleEventType._WorkItemStateChanged, EventWorkItemStateChanged);
	if (window.EventSessionStatusChanged)
		listen(teleEventType._SessionStatusChanged, EventSessionStatusChanged);
	if (window.EventTranscriptLineAdded)
		listen(teleEventType._TranscriptLineAdded, EventTranscriptLineAdded);
	if (window.EventUpdated)
		listen(teleEventType._Updated, EventUpdated);
	if (window.EventWorkItemAdded)
		listen(teleEventType._WorkItemAdded, EventWorkItemAdded);
	if (window.EventWorkItemRemoved)
		listen(teleEventType._WorkItemRemoved, EventWorkItemRemoved);
	if (window.EventAgentStatusChanged)
		listen(teleEventType._AgentStatusChanged, EventAgentStatusChanged);
}