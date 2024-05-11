// src/app/models/visitor-pass-requests.model.ts

import { VisitorTypes } from "./visitor-types";

export class VisitorPassRequests {
    visitorPassRequestID!: number;
    raisedByEmployee!: string;
    requestRaisedOn!: string; // Use string for dates when interfacing with JSON
    visitorTypes!: VisitorTypes;
    purposeOfVisit!: string;
    requestStatus!: string;
    requestProccessedByEmployee!: string;
    requestProccessedOn!: string;
    visitDate!: string;
    cancellationReason!: string;
    location!: string;
    visitorName!: string;
    visitorAge!: number;
    comingFrom: string | undefined;
  }
  