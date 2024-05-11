// src/app/models/visitors-id-proofs.model.ts

import { VisitorPassRequests } from "./visitor-pass-requests";


export class VisitorsIdProofs {
  requestId!: number;
  visitorPassRequests!: VisitorPassRequests;
  iDProofType!: string;
  iDProofNo!: string;
  iDProofURL!: string;
}
